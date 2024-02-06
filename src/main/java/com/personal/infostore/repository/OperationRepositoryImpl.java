package com.personal.infostore.repository;

import com.personal.infostore.model.MeasurementType;
import com.personal.infostore.model.Operation;
import com.personal.infostore.model.OperationType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Optional;
import java.util.Set;
@Repository
@RequiredArgsConstructor
public class OperationRepositoryImpl implements OperationRepository{

    private final JedisPool pool;

    @Override
    public Optional<Operation> findBySensorId(long sensorId,
                                              Set<MeasurementType> types,
                                              Set<OperationType> operationTypes) {
        try(Jedis jedis = pool.getResource()){
            if(!jedis.sismember(

            ))
        }


        return Optional.empty();
    }
}
