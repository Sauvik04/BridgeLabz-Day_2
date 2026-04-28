class UC1_MaxInteger {
    public static Integer testMaximum(Integer x, Integer y, Integer z) {
        Integer max = x;
        if (y.compareTo(max) > 0)
            max = y;
        if (z.compareTo(max) > 0)
            max = z;
        return max;
    }
    public static void main(String[] args) {

        System.out.println("Max: " + testMaximum(10, 20, 15));
        System.out.println("Max: " + testMaximum(30, 20, 10));
        System.out.println("Max: " + testMaximum(10, 40, 20));
    }
}