package com.adventofcode.day5;

public class FloorMap {
    private int[][] map;

    public FloorMap(int numberOfRowsAndColumns) {
        map = new int[numberOfRowsAndColumns][numberOfRowsAndColumns];
    }

    public void addVents(int x1, int y1, int x2, int y2) {
        if (x1 == x2) {
            int from = Math.min(y1, y2);
            int to = Math.max(y1, y2);
            for (int i = from; i <= to; ++i) {
                map[i][x1] = map[i][x1] + 1;
            }
        } else if (y1 == y2) {
            int from = Math.min(x1, x2);
            int to = Math.max(x1, x2);
            for (int i = from; i <= to; ++i) {
                map[y1][i] = map[y1][i] + 1;
            }
        } else {
            calculateDiagonalCoordinates(x1, y1, x2, y2);
        }
    }

    public int countDangerousAreas() {
        int count = 0;

        for (int i = 0; i < map.length; ++i) {
            for (int j = 0; j < map.length; ++j) {
                if (map[i][j] > 1) count++;
            }
        }
        return count;
    }

    private void calculateDiagonalCoordinates(int x1, int y1, int x2, int y2) {
        if (x1 == y1 && x2 == y2) {
            int from = Math.min(x1, x2);
            int to = Math.max(x1, x2);
            for (int i = from; i <= to; ++i) {
                for (int j = 0; j <= to; ++j) {
                    if (i == j) {
                        map[i][j] = map[i][j] + 1;
//                         System.out.println(i + "," + j);
                    }
                }
            }
//             System.out.println("\n");
        } else {
            if (x1 < x2 && y1 < y2) {
                int step = x1 + y1;
                for (int i = x1; i <= x2; ++i) {
                    for (int j = y1; j <= y2; ++j) {
                        if (i + j == step) {
                            map[j][i] = map[j][i] + 1;
                            step += 2;
//                             System.out.println(i + "," + j);
                            break;
                        }
                    }
                }
//                System.out.println("\n");
            } else if (x1 > x2 && y1 > y2) {
                int step = x1 + y1;
                for (int i = x1; i >= x2; --i) {
                    for (int j = y1; j >= y2; --j) {
                        if (i + j == step) {
                            map[j][i] = map[j][i] + 1;
                            step -= 2;
//                            System.out.println(i + "," + j);
                            break;
                        }
                    }
                }
//                   System.out.println("\n");
            } else if (x1 < x2 && y1 > y2) {
                for (int i = x1; i <= x2; ++i) {
                    for (int j = y1; j >= y2; --j) {
                        if (i + j == x1 + y1) {
                            map[j][i] = map[j][i] + 1;
//                            System.out.println(i + "," + j);
                        }
                    }
                }
//                   System.out.println("\n");
            } else if (x1 > x2 && y1 < y2) {
                for (int i = x1; i >= x2; --i) {
                    for (int j = y1; j <= y2; ++j) {
                        if (i + j == x1 + y1) {
                            map[j][i] = map[j][i] + 1;
//                            System.out.println(i + "," + j);
                        }
                    }
                }
//                   System.out.println("\n");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < map.length; ++i) {
            for (int j = 0; j < map.length; ++j) {
                if (map[i][j] == 0) {
                    result.append(".");
                } else {
                    result.append(map[i][j]);
                }
            }
            result.append("\n");
        }

        return result.toString();
    }
}
