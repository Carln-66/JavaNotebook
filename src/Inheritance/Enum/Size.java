package Inheritance.Enum;

enum Size {
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

    private Size(String abbreviation)
    {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation()
    {
        return abbreviation;
    }

    private String abbreviation;
}