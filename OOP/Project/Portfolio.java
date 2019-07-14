import java.util.ArrayList;

class Portfolio {
    private ArrayList<Project> projects;

    public Portfolio() {
        projects = new ArrayList<Project>();
    }

    public void setProjects(Project project) {
        this.projects.add(project);
    }

    public ArrayList<Project> getProjects() {
        return this.projects;
    }

    public void showPortfolio() {
        this.printElevatorPitches();
        System.out.println("Total portfolio cost: $" + this.getPortfolioCost());
    }

    private void printElevatorPitches() {
        for(Project project : this.projects) {
            System.out.println(project.elevatorPitch());
        }
    }

    private double getPortfolioCost() {
        double portfolioCost = 0;
        for(Project project : this.projects) {
            portfolioCost += project.getInitialCost();
        }
        return portfolioCost;
    }

}
