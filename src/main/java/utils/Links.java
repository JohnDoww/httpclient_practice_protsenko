package utils;

public class Links {

    public Links(){
    }

    private final String INVENTORY ="https://petstore.swagger.io/#/store/inventory";

    public String GET_INVENTORY() {
        return INVENTORY;
    }

    private final String CREATE_PET ="https://petstore.swagger.io/v2/pet";

    public String GET_CREATE_PET() {
        return CREATE_PET;
    }

    private final String FIND_PET_BY_ID ="https://petstore.swagger.io/v2/pet/";

    public String GET_FIND_PET_BY_ID() {
        return FIND_PET_BY_ID;
    }

    private final String DELETE_PET_BY_ID ="https://petstore.swagger.io/v2/pet/";

    public String GET_DELETE_PET_BY_ID() {
        return DELETE_PET_BY_ID;
    }




}
