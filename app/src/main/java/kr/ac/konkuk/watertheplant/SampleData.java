package kr.ac.konkuk.watertheplanttest;

public class SampleData {
    private int picture;
    private String plantName;
    private String wateringCycleSummer;
    private String wateringCycleWinter;

    public SampleData(int poster, String plantName, String wateringCycleSummer, String wateringCycleWinter){
        this.picture = poster;
        this.plantName = plantName;
        this.wateringCycleSummer = wateringCycleSummer;
        this.wateringCycleWinter = wateringCycleWinter;

    }

    public int getPoster()
    {
        return this.picture;
    }

    public String getPlantName()
    {
        return this.plantName;
    }

    public String getWateringCycleSummer()
    {
        return this.wateringCycleSummer;
    }

    public String getWateringCycleWinter()
    {
        return this.wateringCycleWinter;
    }
}
