package name.lorenzani.andrea.hackerrank.deliveroo.MagicSquare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Result {

    public static int formingMagicSquare(List<List<Integer>> s) {
        final int[] rows = new int[3];
        final int[] columns = new int[3];
        final int[] diagonals = new int[2];

        for(int ri = 0; ri < 3; ri++) {
            for(int ci = 0; ci < 3; ci++) {
                int value = s.get(ri).get(ci);
                rows[ri] += value;
                columns[ci] += value;
                if(ri==ci) diagonals[0] += value;
                if(ri==2-ci) diagonals[1] += value;
            }
        }
        int cost = 0;
        boolean isBalanced = false;
        while(!isBalanced) {
            int newCost = balance(rows, columns, diagonals, s);
            isBalanced = newCost == 0;
            cost += newCost;
        }
        return cost;
    }

    private static int balance(int[] rows, int[] columns, int[] diagonals, List<List<Integer>> s) {
        int[] values = new int[28];
        for(int ri=0; ri<3; ri++) values[rows[ri]]++;
        for(int ci=0; ci<3; ci++) values[columns[ci]]++;
        values[diagonals[0]]++;
        values[diagonals[1]]++;
        int maxVal=-1;
        int magicConstant = -1;
        for(int i=0;i<28; i++) {
            if(values[i]>maxVal) {
                magicConstant = i;
                maxVal = values[i];
            }
        }

        int rcand=-1, ccand=-1;
        for(int ri=0; ri<3; ri++) {
            if(magicConstant!=rows[ri]) {
                if(rcand==-1 || Math.abs(rows[rcand]-magicConstant)<Math.abs(rows[ri]-magicConstant)) {
                    rcand=ri;
                }
            }
        }
        for(int ci=0; ci<3; ci++) {
            if(magicConstant!=columns[ci]) {
                if(ccand==-1 || Math.abs(columns[ccand]-magicConstant)<Math.abs(columns[ci]-magicConstant)) {
                    ccand=ci;
                }
            }
        }
        if(ccand!=-1 || rcand!=-1) {
            if (ccand != -1 && rcand == -1 && diagonals[0] != magicConstant) {
                rcand = ccand;
            } else if (ccand == -1 && rcand != -1 && diagonals[0] != magicConstant) {
                ccand = rcand;
            } else if (ccand != -1 && rcand == -1 && diagonals[1] != magicConstant) {
                rcand = 2 - ccand;
            } else if (ccand == -1 && rcand != -1 && diagonals[1] != magicConstant) {
                ccand = 2 - rcand;
            } else if (Math.abs(diagonals[0] - magicConstant) < Math.min(Math.abs(columns[ccand] - magicConstant), Math.abs(rows[rcand] - magicConstant))) {
                if (Math.abs(columns[ccand] - magicConstant) >= Math.abs(rows[rcand] - magicConstant)) ccand = rcand;
                else rcand = ccand;
            } else if (Math.abs(diagonals[1] - magicConstant) < Math.min(Math.abs(columns[ccand] - magicConstant), Math.abs(rows[rcand] - magicConstant))) {
                if (Math.abs(columns[ccand] - magicConstant) >= Math.abs(rows[rcand] - magicConstant))
                    ccand = 2 - rcand;
                else rcand = 2 - ccand;
            }

            if(rows[rcand] != magicConstant ||
                    columns[ccand] != magicConstant ||
                    diagonals[0] != magicConstant ||
                    diagonals[1] != magicConstant) {
                final int mc = magicConstant;
                int val = Stream.of(rows[rcand], columns[ccand], diagonals[0], diagonals[1])
                        .mapToInt(x -> mc-x)
                        .filter(x-> x!=0).reduce(-30, (id,x) -> (Math.abs(x)<Math.abs(id))?x:id);
                int prevVal = s.get(rcand).get(ccand);
                System.out.println(String.format("Changing (%d, %d) from %d to %d", rcand, ccand, prevVal, prevVal+val));
                s.get(rcand).set(ccand, prevVal+val);
                rows[rcand] += val;
                columns[ccand] += val;
                if(rcand==ccand) diagonals[0] += val;
                if(rcand == 2-ccand) diagonals[1] += val;
                return val;
            }
        }
        return 0;
    }

    private static int balanceOld(int[] rows, int[] columns, int[] diagonals, List<List<Integer>> s) {
        int magicConstant = 0;
        int cost = 0;
        int rcand = -1, ccand = -1, val = 0;
        for(int ri = 0; ri < 3; ri++) {
            magicConstant = Math.max(magicConstant, rows[ri]);
            if(rcand == -1 || rows[rcand] > rows[ri]) {
                rcand = ri;
            }
        }
        for(int ci = 0; ci < 3; ci++) {
            magicConstant = Math.max(magicConstant, columns[ci]);
            if(ccand == -1 || columns[ccand] > columns[ci]) {
                ccand = ci;
            }
        }
        for(int di = 0; di < 2; di++) {
            magicConstant = Math.max(magicConstant, diagonals[di]);
        }
        if(diagonals[0] < magicConstant && rcand!=ccand) {
            if(rows[rcand] > columns[ccand] && rows[rcand] < diagonals[0]) ccand = rcand;
            if(rows[rcand] < columns[ccand] && columns[ccand] < diagonals[0]) rcand = ccand;
        }
        if(diagonals[1] < magicConstant && rcand!=2-ccand) {
            if(rows[rcand] > columns[ccand] && rows[rcand] < diagonals[0]) ccand = 2-rcand;
            if(rows[rcand] < columns[ccand] && columns[ccand] < diagonals[0]) rcand = 2-ccand;
        }


        if(rows[rcand] != magicConstant ||
                columns[ccand] != magicConstant ||
                diagonals[0] != magicConstant ||
                diagonals[1] != magicConstant) {
            final int mc = magicConstant;
            val = magicConstant - List.of(rows[rcand], columns[ccand], diagonals[0], diagonals[1]).stream().filter(x -> x<mc).mapToInt(Integer::intValue).max().orElse(0);
            int prevVal = s.get(rcand).get(ccand);
            System.out.println(String.format("Changing (%d, %d) from %d to %d", rcand, ccand, prevVal, prevVal+val));
            s.get(rcand).set(ccand, s.get(rcand).get(ccand)+val);
            rows[rcand] += val;
            columns[ccand] += val;
            if(rcand==ccand) diagonals[0] += val;
            if(rcand == 2-ccand) diagonals[1] += val;
            cost = val;
        }

        return cost;
    }

}
