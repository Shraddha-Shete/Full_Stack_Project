package com.example.demo.serviceimpl;

public class PriceCalculator {

    private static final double SINGLE_ROOM_MULTIPLIER = 1.0;
    private static final double DOUBLE_ROOM_MULTIPLIER = 1.5;
    private static final double SUITE_ROOM_MULTIPLIER = 2.0;
    private static final double DELUXE_ROOM_MULTIPLIER = 2.5;

    public static double getMultiplier(String roomType) {
        switch (roomType.toLowerCase()) {
            case "double":
                return DOUBLE_ROOM_MULTIPLIER;
            case "suite":
                return SUITE_ROOM_MULTIPLIER;
            case "deluxe":
                return DELUXE_ROOM_MULTIPLIER;
            case "single":
            default:
                return SINGLE_ROOM_MULTIPLIER;
        }
    }
}
