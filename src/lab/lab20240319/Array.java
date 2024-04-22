package lab.lab20240319;

public class Array {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        int k = 7;

        int left = 0; // 배열의 시작 부분을 가리키는 포인터
        int right = arr.length - 1; // 배열의 끝 부분을 가리키는 포인터
        boolean found = false;

        while (left < right) { // 두 포인터가 교차되기 전까지 반복
            int sum = arr[left] + arr[right];

            if (sum == k) { // 합이 k와 같으면, 해당 원소 출력
                System.out.println(arr[left] + " + " + arr[right] + " = " + k);
                found = true;
                left++; // 찾고 나서도 다른 쌍이 있을 수 있으니 왼쪽 포인터를 오른쪽으로 이동
            } else if (sum < k) { // 합이 k보다 작으면, 왼쪽 포인터를 오른쪽으로 이동
                left++;
            } else { // 합이 k보다 크면, 오른쪽 포인터를 왼쪽으로 이동
                right--;
            }
        }

        if (!found) {
            System.out.println("None"); // 합이 k가 되는 두 원소가 없는 경우
        }
    }
}
