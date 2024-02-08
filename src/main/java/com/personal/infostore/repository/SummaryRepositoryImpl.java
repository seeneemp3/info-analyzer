package com.personal.infostore.repository;

import com.personal.infostore.config.RedisSchema;
import com.personal.infostore.model.MeasurementType;
import com.personal.infostore.model.Summary;
import com.personal.infostore.model.SummaryType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Optional;
import java.util.Set;

@Repository
@RequiredArgsConstructor
public class SummaryRepositoryImpl implements SummaryRepository {

    private final JedisPool pool;

    @Override
    public Optional<Summary> findBySensorId(long sensorId,
                                            Set<MeasurementType> mTypes,
                                            Set<SummaryType> sTypes) {
        try (Jedis jedis = pool.getResource()) {

            if (!jedis.sismember(RedisSchema.sensorKeys(), String.valueOf(sensorId))) {
                return Optional.empty();
            }

            if (mTypes.isEmpty() && !sTypes.isEmpty()) {
                return getSummary(sensorId, Set.of(MeasurementType.values()), sTypes, jedis);

            } else if (!mTypes.isEmpty() && sTypes.isEmpty()) {
                return getSummary(sensorId, mTypes, Set.of(SummaryType.values()), jedis);

            } else return getSummary(sensorId, mTypes, sTypes, jedis);
        }
    }

    private Optional<Summary> getSummary(long sensorId,
                                         Set<MeasurementType> mTypes,
                                         Set<SummaryType> sTypes,
                                         Jedis jedis) {
        var summary = new Summary();
        summary.setSensorId(sensorId);
        for (MeasurementType mType : mTypes) {
            for (SummaryType sType : sTypes) {
                var entry = new Summary.SummaryEntry();
                entry.setType(sType);
                String value = jedis.hget(RedisSchema.summaryKey(sensorId, mType), sType.name().toLowerCase());
                if (value != null) {
                    entry.setValue(Double.parseDouble(value));
                }
                summary.addValue(mType, entry);
            }
        }
        return Optional.of(summary);
    }
}
