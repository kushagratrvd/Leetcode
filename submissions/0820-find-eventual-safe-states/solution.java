class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> graph2 = new ArrayList<>();
        for(int i=0; i<graph.length; i++) graph2.add(new ArrayList<>());
        List<Integer> ans = new ArrayList<>();
        //Set<Integer> set = new HashSet<>();
        Stack<Integer> q = new Stack<>();
        int[] ind = new int[graph.length];
        for(int i=0; i<graph.length; i++){
            int len = graph[i].length;
            for(int j:graph[i]){
                graph2.get(j).add(i);
            }
            ind[i] = len;
            if(len == 0){
                //set.add(i);
                q.push(i);
            } 
        }
        while(!q.isEmpty()){
            int curr = q.pop();
            ans.add(curr);
            List<Integer> temp = graph2.get(curr);
            for(int j:temp){
                ind[j]--;
                if(ind[j] == 0) q.push(j);
            }
        }
        /*for(int i=0; i<graph.length; i++){
            boolean flag = true;
            for(int j=0; j<graph[i].length; j++){
                if(set.contains(graph[i][j])) continue;
                flag = false;
                break;
            }
            if(graph[i].length > 0 && flag) ans.add(i);
        }*/
        Collections.sort(ans);
        return ans;
    }
}
