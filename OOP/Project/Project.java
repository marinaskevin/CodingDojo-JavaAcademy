class Project {

    private String name;
    private String description;
    private double initialCost;

    public Project() {
    }

    public Project(String name) {
        this.name = name;
    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setInitialCost(double initialCost) {
        this.initialCost = initialCost;
    }

    public double getInitialCost() {
        return this.initialCost;
    }

    public String elevatorPitch() {
        return this.name + " ($" + this.initialCost + "): " + this.description;
    }
}
