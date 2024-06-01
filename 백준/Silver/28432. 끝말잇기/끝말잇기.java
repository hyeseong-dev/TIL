import java.io.*;
import java.util.*;


public class Main {

    private static String QUESTION_MARK = "?";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {

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
            List<String> candidates = new ArrayList<>();


            // 후보 단어 입력
            for (int i = 0; i < M; i++) {
                candidates.add(br.readLine());
            }
            if (record.size() == 1 && candidates.size() == 1) {
                bw.append(candidates.get(0));
                bw.flush();
                return;
            }

            List<String> copiedCandidates = new ArrayList<>(candidates);

            // 후보 단어 중 끝말잇기에 있는 단어 삭제하기
            copiedCandidates.removeAll(record);

            char endChar;
            char startChar;


            String firsElement = record.get(0); // 끝말잇기 0번째 인덱스의 요소(단어 혹은 `?`)
            String lastElement = record.get(recordSize - 1); // 끝말잇기 마지막 인덱스의 요소(단어 혹은 `?`

            StringBuilder sb = new StringBuilder();
            if (firsElement.equals(QUESTION_MARK)) {
                // ?가 끝말잇기 기록의 0인덱스인 경우, 후보 단어의 마지막 문자와 일치하는 것 가져오기
                // 끝말잇기 기록 리스트 인덱스 1에서 문자를 선택하고 0번째 인덱스를 선택 char를 추출
                if (record.size() > 1) {
                    startChar = record.get(1).charAt(0);

                    for (String candidate : copiedCandidates) {
                        // 후보 단어가 끝말잇기 규칙에 맞는지 확인
                        if (candidate.charAt(candidate.length() - 1) == startChar) {
                            sb.append(candidate);
                            break;
                        }
                    }
                }

            } else if (lastElement.equals(QUESTION_MARK)) {
                // ?가 끝말잇기 기록의 마지막인 경우,
                //  끝말잇기 기록 마지막 인덱스 앞의 요소 가져와서 요소의 마지막 char 가져오기
                //  후보 단어 중 첫 문자와 일치하는 것 가져오기
                if (record.size() > 1) {
                    String previousRecord = record.get(recordSize - 2);
                    endChar = previousRecord.charAt(previousRecord.length() - 1);

                    for (String candidate : copiedCandidates) {
                        // 후보 단어가 끝말잇기 규칙에 맞는지 확인
                        if (candidate.charAt(0) == endChar) {
                            sb.append(candidate);
                            break;
                        }
                    }
                }


            } else {
                // ?문자 앞뒤 인덱스에 단어가 있는 경우,
                // 끝말잇기 기록의 첫 단어의 끝 글자와 마지막 단어의 첫 글자를 비교하여 후보 단어 중에서 선택
                char lastChr = 0;
                char firstChr = 0;

                for (int i = 1; i < recordSize - 1; i++) {
                    if (record.get(i).equals(QUESTION_MARK)) {
                        String previousWord = record.get(i - 1);
                        lastChr = previousWord.charAt(previousWord.length() - 1);

                        String afterWord = record.get(i + 1);
                        firstChr = afterWord.charAt(0);
                        break;
                    }
                }

                for (String candidate : copiedCandidates) {
                    if (candidate.charAt(0) == lastChr && candidate.charAt(candidate.length() - 1) == firstChr) {
                        sb.append(candidate);
                        break;
                    }
                }
            }

            bw.append(sb.toString());
            bw.flush();

        }finally {
            bw.close();
            br.close();
        }

        }
    }


