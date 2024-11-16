import java.io.*;
import java.util.*;

public class BAEK_24060 {
    static int K;
    static int[] tmp;
    static int cnt=0;
    static int result=-1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        tmp = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(arr, 0, N-1);
        
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    public static void merge_sort(int[] A, int p, int r){
        if(p < r){ //배열이 1보다 클 때 실행
            int q = (p+r) / 2; //중간 지점
            merge_sort(A, p, q); //왼쪽 정렬
            merge_sort(A, q+1, r); //오른쪽 정렬
            merge(A,p,q,r); //병합
        }
    }

    public static void merge(int[] A, int p, int q, int r){
        int i = p; //왼쪽 배열 시작 위치
        int j = q+1; //오른쪽 배열 시작 위치
        int t = 0; //임시 배열 위치

        //1단계) 두 배열 비교하며 작은 값부터 tmp에 저장
        while(i <= q && j <= r){
            if(A[i] <= A[j]){ //왼쪽 배열 값이 작으면 해당 값 저장
                tmp[t++] = A[i++];
            } else {          //오른쪽 배열 값이 작으면 해당 값 저장
                tmp[t++] = A[j++];
            } 
        }

        //2단계) 왼쪽 배열에 남은 값들을 tmp에 저장
        while(i <= q){
            tmp[t++] = A[i++];
        }

        //3단계) 오른쪽 배열에 남은 값들을 tmp에 저장
        while(j <= r){
            tmp[t++] = A[j++];
        }

        //4단계) 정렬된 tmp 배열을 원래 배열 A에 복사
        i = p; //배열 시작 위치로 돌아감
        t = 0; //tmp 배열 시작 위치로 돌아감
        while(i <= r){
            cnt++; //저장 시 cnt 증가
            if(cnt == K){ //K번째 저장하는 값을 찾았다면
                result = tmp[t]; //해당 값 결과로 저장
            }
            //자바에서 배열은 참조 타입이기 때문에, A[i]를 수정하든 arr[i]를 수정하든 같은 메모리 공간의 값이 변경
            A[i++] = tmp[t++]; //tmp 값을 원래 배열에 복사
        }
    }
}
