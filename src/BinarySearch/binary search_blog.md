# 二分查找


## 二分查找的方法

通过区间方式一次舍弃一半的数据后， 抓住左右指针的关系， [0， left-1] 的数据一定是<target的
而[right+1，length-1]是>=target。
其中最后right+1=left

## 二分查找的核心

二分查找需要有几个核心需要牢记

### 顺序

二分查找一定需要数组有一定顺序的，如果原题目没有顺序， 但又只是一个查找任务， 可以考虑先排序再查找
'''

Arrays.sort(nums);

'''
。

### 二分查找的边界

其实核心是抓住循环不变量
right+1=left

若想要找到小于target的数就可以用target的right指针

若是想要找到不小于target指针便是left指针

若是找target区间 便是先找到target+1的right指针 和target的left指针即可

（注意数组边界可以看https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/）

### 使用场景

如果发现题目是找出第一个大于的数， 或者最后一个数， 

或者区间问题，

再或者可以转化为查找问题来解决， 可以考虑二分查找

## 代码实例及其基础讲解（闭区间写法）
'''

    public int binarySearch(int[] nums, int target){
        int left=0;
        int right=nums.length-1;
        while(right>=left){
            int mid=left+(right-left)/2;
            if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }
        }
        return right+1;
    }

'''



