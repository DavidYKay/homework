package edu.mccc.ist239.piechart;

public class DataModel {

    private int[] data = new int[5];

    public DataModel() {
        data = new int[] {
            100,
            50,
            10,
            25,
            80
        };
        //open db connection
        //fetch that shit
    }

    public int[] getData() {
        return data;
    }

}
