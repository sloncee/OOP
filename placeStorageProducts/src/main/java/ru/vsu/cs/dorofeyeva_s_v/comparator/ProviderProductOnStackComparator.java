package ru.vsu.cs.dorofeyeva_s_v.comparator;

import ru.vsu.cs.dorofeyeva_s_v.model.ProductOnStack;

import java.util.Comparator;

public class ProviderProductOnStackComparator implements Comparator<ProductOnStack> {

    @Override
    public int compare(ProductOnStack o1, ProductOnStack o2) {
        return o1.getProvider().compareTo(o2.getProvider());
    }
}
