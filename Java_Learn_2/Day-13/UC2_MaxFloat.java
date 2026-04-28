class UC2_MaxFloat {
    public static Float testMaximum(Float x, Float y, Float z) {
        Float max = x;
        if (y.compareTo(max) > 0)
            max = y;

        if (z.compareTo(max) > 0)
            max = z;
        return max;
    }
    public static void main(String[] args) {
        System.out.println("Max: " + testMaximum(10.5f, 20.2f, 15.3f));
        System.out.println("Max: " + testMaximum(30.1f, 20.2f, 10.5f));
        System.out.println("Max: " + testMaximum(10.5f, 40.8f, 20.2f));
    }
}