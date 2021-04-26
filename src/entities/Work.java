package entities;

import java.util.*;

public class Work {
    private int workID;
    private Artist artistOwner;
    private String workContent;
    
    public Work(int workID, Artist artistOwner, String workContent) {
        this.workID = workID;
        this.artistOwner = artistOwner;
        this.workContent = workContent;
    }
}