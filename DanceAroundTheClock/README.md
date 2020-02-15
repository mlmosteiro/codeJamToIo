#   Disclaimer 
  
  The method **getEvenDancerNeighbours** its wrong... I never make it work:
  ```java
  private List<Integer> getEvenDancerNeighbours(int dancerId, int totalDancers, int turns) {
        Integer right = (((dancerId - 1) + (2 * turns)) % totalDancers);
        Integer left = (((dancerId + 2) + (2 * turns)) % totalDancers);

        return new ArrayList<>(Arrays.asList(left, right));
    }
```

Any idea, write me : @mlmosteiro everywhere :grin:
