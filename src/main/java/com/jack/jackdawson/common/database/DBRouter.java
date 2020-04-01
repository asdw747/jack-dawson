package com.jack.jackdawson.common.database;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

@Data
@Accessors(chain = true)
public class DBRouter extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DBContext.getDbType();
    }

}
