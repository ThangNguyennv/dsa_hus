package Hw1_23001938_NguyenVanThang.bai1;

public class Comment {
    /*
     - Với trường hợp mảng đã được sắp xếp
     +) N = 100
        Selection sort : khoảng 4950 phép tính <-> O(N^2)
        Bubble sort: khoảng 100 phép tính <-> O(N)
        Insertion sort: khoảng 198 phép tính <-> O(N)
        Merge sort: khoảng 356 phép tính <-> O(NLOG(N))
        Quick sort: khoảng 5000 phép tính <-> O(N^2)
        => Nên sử dụng Bubble sort
     +) N = 1000
        Selection sort : khoảng 5 * 10^5 phép tính <-> O(N^2)
        Bubble sort: khoảng 1000 phép tính <-> O(N)
        Insertion sort: khoảng 2000 phép tính <-> O(N)
        Merge sort: khoảng 5000 phép tính <-> O(NLOG(N))
        Quick sort: khoảng 10^6 phép tính <-> O(N^2)
        => Nên sử dụng Bubble sort
    +) N = 10000
        Selection sort : khoảng 5 * 10^7 phép tính <-> O(N^2)
        Bubble sort: khoảng 10000 phép tính <-> O(N)
        Insertion sort: khoảng 20000 phép tính <-> O(N)
        Merge sort: khoảng 40000 phép tính <-> O(NLOG(N))
        Quick sort: khoảng 10^8 phép tính <-> O(N^2)
        => Nên sử dụng Bubble sort
     +) N = 100000
        Selection sort : khoảng 5 * 10^9 phép tính <-> O(N^2)
        Bubble sort: khoảng 100000 phép tính <-> O(N)
        Insertion sort: khoảng 2 * 10^5 phép tính <-> O(N)
        Merge sort: khoảng 5 * 10^5 phép tính <-> O(NLog(N))
        Quick sort: khaonrg 10^10 phép tính <-> O(N^2)
        => Nên sử dụng Bubble sort

     - Với trường hợp mảng chưa được sắp xếp
     +) N = 100
        Selection sort : khoảng 4950 phép tính <-> O(N^2)
        Bubble sort: khoảng 4950 phép tính <-> O(N^2)
        Insertion sort: khoảng 198 phép tính <-> O(N)
        Merge sort: khoảng 543 phép tính <-> O(NLog(N))
        Quick sort: khoảng 625 phép tính <-> O(NLOG(N))
        => Nên sử dụng Insertion sort
     +) N = 1000
        Selection sort : khoảng 10^6 phép tính <-> O(N^2)
        Bubble sort: khoảng 10^6 phép tính <-> O(N^2)
        Insertion sort: khoảng 10^6 phép tính <-> O(N^2)
        Merge sort: khoảng 3000 phép tính <-> O(NLOG(N))
        Quick sort: khoảng 3000 phép tính <-> O(NLOG(N))
        => Nên sử dụng Merge sort hoặc Quick sort
    +)  N = 10000
        Selection sort : khoảng 10^8 phép tính <-> O(N^2)
        Bubble sort: khoảng 10^8 phép tính <-> O(N^2)
        Insertion sort: khoảng 10^8 phép tính <-> O(N^2)
        Merge sort: khoảng 40000 phép tính <-> O(NLOG(N))
        Quick sort: khoảng 40000 phép tính <-> O(NLOG(N))
        => Nên sử dụng Merge sort hoặc Quick sort
     +) N = 100000
        Selection sort : khoảng 10^10 phép tính <-> O(N^2)
        Bubble sort: khoảng 10^10 phép tính <-> O(N^2)
        Insertion sort: khoảng 10^10 phép tính <-> O(N^2)
        Merge sort: khoảng 5 * 10^5 phép tính <-> O(NLOG(N))
        Quick sort: khoảng 5 * 10^5 phép tính <-> O(NLOG(N))
        => Nên sử dụng Merge sort hoặc Quick sort
    */
}
