class ProjectTest {
    public static void main(String[] args) {

        Project codeRed = new Project();
        Project codeBlue = new Project();
        Project codeGreen = new Project("Code Green");
        Project codeYellow = new Project("Code Yellow","Sticking it to the man");

        codeRed.setName("Code Red");
        codeBlue.setName("Code Blue");

        codeRed.setDescription("Doing what has worked for us");
        codeBlue.setDescription("Expanding on something new");
        codeGreen.setDescription("Preserving the environment");

        codeRed.setInitialCost(80);
        codeBlue.setInitialCost(90);
        codeGreen.setInitialCost(100);
        codeYellow.setInitialCost(70);

        System.out.println("\nMethod tests");
        System.out.println("getName(): "+codeRed.getName());
        System.out.println("getInitialCost(): "+codeRed.getInitialCost());
        System.out.println("getDescription(): "+codeRed.getDescription());

        Portfolio portfolio = new Portfolio();

        portfolio.setProjects(codeRed);
        portfolio.setProjects(codeBlue);
        portfolio.setProjects(codeGreen);
        portfolio.setProjects(codeYellow);

        System.out.println("\n"+portfolio.getProjects()+"\n");
        portfolio.showPortfolio();

    }     
}
