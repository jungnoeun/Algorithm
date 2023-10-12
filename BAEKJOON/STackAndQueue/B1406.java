package BAEKJOON.STackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class B1406{

        /*	   미완    */

        // L : 커서를 왼쪽으로 옮김
        // D : 커서를 오른쪽으로 옮김
        // B : 커서 왼쪽에 있는 문자를 삭제함
        // P $ : $라는 문자를 커서 왼쪽에 추가함

        static LinkedList<String> li = new LinkedList<>();

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            //StringBuilder sbr = new StringBuilder();

            String str = br.readLine();
            int times = Integer.parseInt(br.readLine());

            // 초기 링크드리스트 입력
            for(int i=0; i<str.length(); i++) {
                li.add(str.charAt(i)+"");
            }

            ListIterator<String> iter = li.listIterator();

            while(iter.hasNext()) {
                iter.next();
            }


            for(int i=0; i<times; i++) {
                //StringTokenizer st = new StringTokenizer(br.readLine());
                //String comm = st.nextToken();
                String lin = br.readLine();
                Character comm = lin.charAt(0);

                switch(comm) {
                    case 'P':
                        char lcp = lin.charAt(2);
                        iter.add(lcp+"");
                        break;
                    case 'L' :
                        if(iter.hasPrevious())
                            iter.previous();
                        break;
                    case 'D' :
                        if(iter.hasNext())
                            iter.next();
                        break;
                    case 'B' :
                        if(iter.hasPrevious()) {
                            iter.previous();
                            iter.remove();
                        }
                        break;

                    default:
                        break;

                }

                /*
                 * if(comm.equals('P')) { // Lplus(lp); char lcp = lin.charAt(2); iter.add(lcp);
                 * } else if(comm.equals("L")) { // cLeft(); if(iter.hasPrevious())
                 * iter.previous(); } else if(comm.equals("D")) { // cRight();
                 * if(iter.hasNext()) iter.next(); } else if(comm.equals("B")) { // lRemove();
                 * if(iter.hasPrevious()) { iter.previous(); iter.remove(); } }
                 */

            }

            System.out.println(String.join("", li));


            /*
             * for(int i=0; i<li.size(); i++) { bw.write(li.get(i));
             * //sbr.append(li.get(i)); }
             */

            //bw.write(String.valueOf(sbr));

            //br.close();
            //bw.flush();
            //bw.close();
        }


}
