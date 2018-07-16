# Djikstra's Shortest Path Algorithm

Given a directed graph G = (V, E) with positive edge weights, the single-source shortest path problem can be solved using Djikstra's shortest path algorithm.

The time complexity of such is: 
O(m log n)


```
void computePaths(Vertex src):
  src.min := 0
  q.add(src)
     
  while q is not empty:
    u := q.poll();
    
    for each edge e in u.adj:
      v := e.target
      w := e.weight
      dis_to_u := u.min + weight
      if dis_to_u < v.min:
        q.remove(v)
        v.min = dis_to_u
        v.prev = u
        q.add(v)       
```
