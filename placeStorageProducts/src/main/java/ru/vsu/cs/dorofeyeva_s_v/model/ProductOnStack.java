package ru.vsu.cs.dorofeyeva_s_v.model;

import java.util.Objects;

public abstract class ProductOnStack implements Interface {
    private Product product;
    private Stack stack;
    private String provider;

    public ProductOnStack(Product product, Stack stack, String provider) {
        this.product = product;
        this.stack = stack;
        this.provider = provider;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Stack getStack() {
        return stack;
    }

    public void setStack(Stack stack) {
        this.stack = stack;
    }
    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public abstract boolean isSuitable();
    public abstract long getDaysRemaining();

    @Override
    public void print(){
        product.print();
        stack.print();
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductOnStack productOnStack = (ProductOnStack) o;
        return Objects.equals(product, productOnStack.product)
                && Objects.equals(stack, productOnStack.stack)
                && Objects.equals(provider, productOnStack.provider);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, stack, provider);
    }
}