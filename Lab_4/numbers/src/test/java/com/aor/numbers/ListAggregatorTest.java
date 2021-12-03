package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {

    public List<Integer> listToBeTested(){

        return Arrays.asList(1,2,4,2,5);
    }

    @Test
    public void distinct_bug_8726() {
        List<Integer> list = Arrays.asList(1,2,4,2);

        ListAggregator aggregator = new ListAggregator(new ListDeduplicator());
        int distinct = aggregator.distinct(list);

        Assertions.assertEquals(4, distinct);
    }

    @Test
    public void max_bug_7263() {
        List<Integer> list = Arrays.asList(-1,-4,-5);

        ListAggregator aggregator = new ListAggregator(new ListDeduplicator());
        int max = aggregator.max(list);

        Assertions.assertEquals(-1, max);
    }

    @Test
    public void sum() {
        List<Integer> list = listToBeTested();

        ListAggregator aggregator = new ListAggregator(new ListDeduplicator());
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {
        List<Integer> list = listToBeTested();

        ListAggregator aggregator = new ListAggregator(new ListDeduplicator());
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {
        List<Integer> list = Arrays.asList(1,2,4,2,5);

        ListAggregator aggregator = new ListAggregator(new ListDeduplicator());
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {
        List<Integer> list = Arrays.asList(1,2,2,0,5,5);

        GenericListDuplicator deduplicator =
                Mockito.mock(GenericListDuplicator.class);
        ListAggregator aggregator = new ListAggregator(deduplicator);
        Mockito.when(deduplicator.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4));
        int distinct = aggregator.distinct(Arrays.asList(1, 2, 4, 2));
        Assertions.assertEquals(4, distinct);
    }
}
