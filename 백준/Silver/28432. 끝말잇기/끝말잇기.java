
import java.io.*;
import java.util.*;

public class Main {

    private static final String QUESTION_MARK = "?";

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            // 끝말잇기 기록의 길이 N
            int recordSize = Integer.parseInt(br.readLine());

            // 끝말잇기 기록을 저장할 리스트
            List<String> record = new ArrayList<>();

            // 끝말잇기 기록 입력
            for (int i = 0; i < recordSize; i++) {
                record.add(br.readLine());
            }

            // 후보 단어의 개수 M
            int M = Integer.parseInt(br.readLine());

            // 후보 단어를 저장할 리스트
            Set<String> candidateSet = new HashSet<>();
            List<String> candidateList = new ArrayList<>();

            // 후보 단어 입력
            for (int i = 0; i < M; i++) {
                String candidate = br.readLine();
                candidateSet.add(candidate);
                candidateList.add(candidate);
            }

            // 끝말잇기 기록이 1개이고 후보 단어가 1개인 경우 바로 출력하고 종료
            if (record.size() == 1 && candidateList.size() == 1) {
                bw.write(candidateList.get(0));
                return;
            }

            // 후보 단어 중 끝말잇기에 있는 단어 삭제하기
            candidateSet.removeAll(record);

            String result = findMatchingWord(record, candidateSet);
            bw.write(result);
        }
    }

    private static String findMatchingWord(List<String> record, Set<String> candidates) {
        int recordSize = record.size();
        String firstElement = record.get(0);
        String lastElement = record.get(recordSize - 1);

        if (firstElement.equals(QUESTION_MARK)) {
            return handleFirstQuestionMark(record, candidates);
        } else if (lastElement.equals(QUESTION_MARK)) {
            return handleLastQuestionMark(record, candidates);
        } else {
            return handleMiddleQuestionMark(record, candidates);
        }
    }

    private static String handleFirstQuestionMark(List<String> record, Set<String> candidates) {
        if (record.size() <= 1) {
            return "";
        }

        char startChar = record.get(1).charAt(0);

        for (String candidate : candidates) {
            if (candidate.charAt(candidate.length() - 1) == startChar) {
                return candidate;
            }
        }
        return "";
    }

    private static String handleLastQuestionMark(List<String> record, Set<String> candidates) {
        if (record.size() <= 1) {
            return "";
        }

        String previousRecord = record.get(record.size() - 2);
        char endChar = previousRecord.charAt(previousRecord.length() - 1);

        for (String candidate : candidates) {
            if (candidate.charAt(0) == endChar) {
                return candidate;
            }
        }
        return "";
    }

    private static String handleMiddleQuestionMark(List<String> record, Set<String> candidates) {
        for (int i = 1; i < record.size() - 1; i++) {
            if (record.get(i).equals(QUESTION_MARK)) {
                String previousWord = record.get(i - 1);
                char lastChr = previousWord.charAt(previousWord.length() - 1);

                String afterWord = record.get(i + 1);
                char firstChr = afterWord.charAt(0);

                for (String candidate : candidates) {
                    if (candidate.charAt(0) == lastChr && candidate.charAt(candidate.length() - 1) == firstChr) {
                        return candidate;
                    }
                }
            }
        }
        return "";
    }
}
