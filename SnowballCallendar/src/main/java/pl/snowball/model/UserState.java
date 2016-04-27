package pl.snowball.model;

public enum UserState {
	ACTIVE("Active"),
    INACTIVE("Inactive"),
    DELETED("Deleted");
     
    private String state;
     
    private UserState(final String state){
        this.state = state;
    }
     
    public String getState(){
        return this.state;
    }
 
    @Override
    public String toString(){
        return this.state;
    }
 
    public String getName(){
        return this.name();
    }
}
