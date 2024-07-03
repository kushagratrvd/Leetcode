class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int count = 0;
        int j=1;
        /*List<Integer> arrayList = IntStream.of(nums).boxed().collect(Collectors.toList());
        for(int i = 0; i < n-1; i++){
            while(arrayList.get(i) == arrayList.get(i+1)){
                arrayList.remove(i);
                n--;
            }
        }*/
        //ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 1; i < n; i++){
            if(nums[i-1] != nums[i]){
                nums[j]=nums[i];
                count++;
                j++;
            }
        }
        //nums = arrayList.stream().mapToInt(Integer::intValue).toArray();
        System.out.print(nums); 
        return (j);
    }
}
