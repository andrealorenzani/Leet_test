package name.lorenzani.andrea.leet.metaprep._20250527.exclusivetimeoffunctions;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Log> execution = new Stack<>();
        int[] executions = new int[n];
        Log prev = null;
        for(int i=0; i< logs.size(); i++) {
            Log curr = new Log(logs.get(i));
            if(curr.isStart) {
                if(!execution.empty()) executions[execution.peek().id] += getTime(prev, curr);
                prev = curr;
                execution.push(curr);
            }
            else if(!curr.isStart) {
                if(!execution.empty()) executions[execution.peek().id] += getTime(prev, curr);
                prev = curr;
                execution.pop();
            }
        }
        return executions;
    }

    private int getTime(Log start, Log end) {
        if(start.isStart && !end.isStart) return (end.time - start.time) +1;
        if((start.isStart && end.isStart) || (!start.isStart && !end.isStart)) return (end.time - start.time);
        else return (end.time - start.time) -1;
    }
}

class Log {
    int id;
    int time;
    boolean isStart;

    public Log(String value) {
        String[] splitted = value.split(":");
        id = Integer.parseInt(splitted[0]);
        time = Integer.parseInt(splitted[2]);
        isStart = "start".equals(splitted[1]);
    }
}
