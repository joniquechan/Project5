package com.mycompany.project5algo;

public class Sign {
    public int from;
    public int to;
    public double distance;
    public String name;
    public long totalDistance;

    public Sign(int f, int t, double d) {
        from = f;
        to = t;
        distance = d;
    }

    public Sign(String n, long d) {
        name = n;
        totalDistance = d;
    }

    public long getTotalDistance() {
        return totalDistance;
    }

    public String getName() {
        return name;
    }
}
