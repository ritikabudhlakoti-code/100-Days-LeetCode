class Solution {
    void fun(ArrayList<Integer> nums , ArrayList<Integer> temp, int target, List<List<Integer>> ans ){
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(target < 0 || nums.size()==0)
            return;
        for(int i = 0; i< nums.size(); i++){

            if(i > 0 && nums.get(i).equals(nums.get(i-1)))
                continue;
            ArrayList<Integer> ip = new ArrayList<>(nums);
            ArrayList<Integer> op = new ArrayList<>(temp);

            op.add(nums.get(i));

            for(int j = 0 ; j <= i ; j++){
                ip.remove(0);
            }
            fun(ip,op,target - nums.get(i), ans);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<Integer> list = new ArrayList<>();
        for( int n : candidates)
            list.add(n);
        List<List<Integer>> ans = new ArrayList<>();
        fun(list, new ArrayList<>(), target, ans);
        return ans;
    }
}
