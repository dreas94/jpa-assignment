package se.lexicon.dreas94.jpaassignment.entity;

public enum Measurement
{
    TBSP("Tablespoon"),
    TSP("Teaspoon"),
    G("Gram"),
    HG("Hectogram"),
    KG("Kilogram"),
    ML("Milliliter"),
    CL("Centiliter"),
    DL("Deciliter"),
    L("Liter"),
    NO("Number of");

    private String description;

    Measurement(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}

