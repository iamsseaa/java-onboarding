package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiScore = getFinalScore(pobi);
        int crongScore = getFinalScore(crong);

        int answer = determinateWinner(pobiScore, crongScore);
        return answer;
    }

    public static int getFinalScore(List<Integer> participant) {
        List<List<Integer>> seperatedDigits = separateDigits(participant);
        List<Integer> cases = new ArrayList<>();

        for (List<Integer> page : seperatedDigits) {
            cases.add(add(page));
            cases.add(multiply(page));
        }

        int max = getMax(cases);

        return max;
    }

    public static List<List<Integer>> separateDigits(List<Integer> pages) {
        List<List<Integer>> digitsNum = new ArrayList<>();

        for (int page : pages) {
            int [] onePage = Stream.of(String.valueOf(page).split("")).mapToInt(Integer::parseInt).toArray();
            List<Integer> al = Arrays.stream(onePage).boxed().collect(Collectors.toList());
            digitsNum.add(al);
        }

        return digitsNum;
    }

    public static int add(List<Integer> page) {
        return page.stream().mapToInt(Integer::intValue).sum();
    }

    public static int multiply(List<Integer> page) {
        int mul = 1;

        for (int num : page) {
            mul *= num;
        }

        return mul;
    }

    public static int getMax(List<Integer> cases) {
        int max = cases.stream().mapToInt(x -> x).max().getAsInt();
        return max;
    }

    public static int determinateWinner(int pobi, int crong) {
        if (pobi > crong) {
            return 1;
        }
        if (crong > pobi) {
            return 2;
        }
        return 0;
    }
}

class Exception {
    
}