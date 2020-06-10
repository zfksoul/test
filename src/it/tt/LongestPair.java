package it.tt;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 小明是一名算法工程师， 同时也是一名铲屎官。

 某天，他突发奇想，想从猫咪的视频里挖掘一些猫咪的运动信息。

 为了提取运动信息，他需要从视频的每一帧提取“猫咪特征”。

 一个猫咪特征是一个两维的 vectorc< x, y >。

 如果x1=x2并且y1=y2, 那么这俩是同一个特征。

 因此，如果猫咪特征连续一致，可以认为猫咪在运动。

 也就是说，如果特征< a, b >在持续帧里出现，那么它将构成特征运动。

 比如，特征< a, b >在第2/3/4/7/8帧出现，那么该特征将形成两个特征运动2-3-4和7-8。

 现在，给定每一帧的特征，特征的数量可能不一样。

 小明期望能找到最长的特征运动。

 输入格式
 第一行包含一个正整数M，代表视频的帧数。

 接下来的M行，每行代表一帧，其中，第一个数字是该帧的特征个数，接下来的数字是在特征的取值；比如样例输入第三行里，2代表该帧有两个猫咪特征，<1, 1>和<2, 2>。

 输出格式
 输出特征运动的长度作为一行。

 数据范围
 1≤M≤10000
 输入特征总数和不超过100000。
 一帧的特征个数不超过10000。
 特征取值均为非负整数。

 输入样例：
 8
 2 1 1 2 2
 2 1 1 1 4
 2 1 1 2 2
 2 2 2 1 4
 0
 0
 1 1 1
 1 1 1
 输出样例：
 3
 样例解释
 特征<1,1>在连续的帧中连续出现3次，相比其他特征连续出现的次数大，所以输出3。
 */
public class LongestPair {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Pair, Integer> last = new HashMap<>();
        Map<Pair, Integer> cnt = new HashMap<>();
        int res = 0;
        for (int i = 1; i <= n; i++){
            int m = in.nextInt();
            for (int k = 0; k < m; k++){
                int x = in.nextInt();
                int y = in.nextInt();
                Pair p = new Pair(x, y);
                if (!last.containsKey(p)){
                    last.put(p, i);
                    cnt.put(p, 1);
                }
                int index = last.get(p);
                int count = cnt.get(p);
                if (index == i - 1){
                    cnt.put(p, ++count);
                } else if (index < i - 1){
                    cnt.put(p, 1);
                }
                last.put(p, i);
                res = Math.max(res, count);
            }
        }
        System.out.println(res);
    }
}

