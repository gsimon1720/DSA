class RabbitProblem {

    static int rabbitCount(int n) {
        if (n <= 1)
            return n;
        return rabbitCount(n - 1) + rabbitCount(n - 2);
    }

    public static void main(String[] args) {
        int months = 6;
        System.out.println("Rabbit pairs after " + months + " months: " + rabbitCount(months));
    }
}