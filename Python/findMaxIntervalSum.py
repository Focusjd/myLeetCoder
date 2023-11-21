# findMaxIntervalSum
def max_subarray_sum(arr):
    max_current = max_global = arr[0]
    for i in range(1, len(arr)):
        max_current = max(arr[i], max_current + arr[i])
        # max_current = arr[i] if arr[i]>max_current + arr[i] else max_current + arr[i]
        if max_current > max_global:
            max_global = max_current
    return max_global


def FindGreatestSumOfSubArray(self, array: list[int]) -> int:
    current_max = global_max = array[0]
    for i in range(len(array)):
        current_max = 0
        for j in range(i, len(array)):
            current_max += array[j]
            if current_max > global_max:
                global_max = current_max

    return global_max
