package ru.vsu.cs.dorofeyeva_s_v.model;

public abstract class ProductOnStack implements Interface {
    private Product product;
    private Stack stack;

    public ProductOnStack(Product product, Stack stack) {
        this.product = product;
        this.stack = stack;
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

    public abstract boolean isSuitable();
    public abstract long getDaysRemaining();

    @Override
    public void print(){
        product.print();
        stack.print();
        System.out.println();
    }
}