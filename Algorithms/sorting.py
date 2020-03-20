'''
Bubble Sort the i th round generates the n - i th biggest number.
Time complexity:
    BEST: O(n) -- Sorted Array
    AVG: O(n^2)
    WORST: O(n^2)
'''
arr = [6, 4, 2, 6, 7, 1]

def bubbleSort(arr):
    n = len(arr)
    for i in range(0, n):
        for j in range(0, n - i - 1):
            if arr[j] > arr[j + 1]:
                temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp


def insertionSort(arr):
    n = len(arr)
    for i in range(0, n):
        key = arr[i]
        j = i - 1
        while j >= 0 and arr[j] > key:
            arr[j + 1] = arr[j]
            j = j - 1
        arr[j + 1] = key


# bubbleSort(l)
insertionSort(arr)
print(arr)