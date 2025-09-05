class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length == 1) return 1;
        List<double[]> list = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            double val = (double)(target - position[i]) / speed[i];
            list.add(new double[]{(double)position[i], val});
        }
        list.sort((a, b) -> Double.compare(a[0], b[0]));
        double max = list.get(list.size()-1)[1];
        int count = 0;
        for(int i=list.size()-1; i>=0; i--){
            if(list.get(i)[1] > max){
                count++;
                max = list.get(i)[1];
            }
        }
        return count+1;
    }
}
