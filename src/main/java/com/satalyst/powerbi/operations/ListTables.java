package com.satalyst.powerbi.operations;

import com.google.gson.Gson;

import javax.ws.rs.core.UriBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.google.common.base.Preconditions.checkNotNull;
import com.satalyst.powerbi.impl.model.DefaultTable;
import com.satalyst.powerbi.model.Table;
import static com.satalyst.powerbi.operations.MapUtils.getColumns;
import static com.satalyst.powerbi.operations.MapUtils.getList;
import static com.satalyst.powerbi.operations.MapUtils.getString;

/**
 * @author Aidan Morgan
 */
public class ListTables extends AbstractGetOperation<List<Table>> {
    private UUID datasetId;

    public ListTables(UUID datasetId) {
        this.datasetId = checkNotNull(datasetId);
    }

    @Override
    public void buildUri(UriBuilder uri) {
        uri.path("myorg").path("datasets").path(datasetId.toString()).path("tables");

    }

    protected List<Table> parseJson(Gson parser, String s) {
        List<Table> result = new ArrayList<>();

        Map parsed = parser.fromJson(s, Map.class);

        List<Map> tables = getList(parsed, "value");

        for (Map table : tables) {
            result.add(new DefaultTable(getString(table, "name"),getColumns(table,"columns")));
        }

        return result;
    }
}
