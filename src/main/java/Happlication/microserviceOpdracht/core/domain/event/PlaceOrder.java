package Happlication.microserviceOpdracht.core.domain.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PlaceOrder {


    private String tableId;

    public PlaceOrder() {
    }

    public PlaceOrder(String tableId) {
        this.tableId = tableId;
    }

    public String getTableId() {
        return tableId;
    }


}
