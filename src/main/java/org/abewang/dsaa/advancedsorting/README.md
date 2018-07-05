###高级排序


####希尔排序
1. outer: outer = h; outer++.
\
2. inner: inner = outer; inner >= h; inner -= h.
3. h: h <= nElems / 3, h = 3 * h + 1; h = (h - 1) / 3
4. temp



与插入排序比较：
\
插入排序，MaxSize: 1000000  Time cost: 143.87s
\
希尔排序，MaxSize: 1000000  Time cost: 0.118s


####快速排序
 时间复杂度: O(N * logN)