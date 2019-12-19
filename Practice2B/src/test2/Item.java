package test2;

/**
 * A class that represents an item in a bill of sale. Every item has a description
 * and a price. The price of an item is guaranteed to be greater than or
 * equal to zero.
 * 
 *
 */
public class Item implements Comparable<Item> {

    private String desc;
    private int price;

    /**
     * Initialize an item by setting its description and price.
     * 
     * @param description
     *            the item description
     * @param price
     *            the item price
     * @throws IllegalArgumentException
     *             if the item price is less than zero
     */
    public Item(String description, int price) {
        this.desc = description;
        this.setPrice(price);
    }

    /**
     * Initialize an item by copying another item.
     * 
     * @param other
     *            the item to copy
     */
    public Item(Item other) {
        this.desc = other.desc;
        this.price = other.price;
    }

    /**
     * Get the item description.
     * 
     * @return the item description
     */
    public String getDescription() {
        return this.desc;
    }

    /**
     * Set the item description to the specified description.
     * 
     * @param desc
     *            the item description to set
     */
    public void setDescription(String desc) {
        this.desc = desc;
    }

    /**
     * Get the item price.
     * 
     * @return the item price
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * Set the item price to the specified price.
     * 
     * @param price
     *            the item price to set
     * @throws IllegalArgumentException
     *             if the argument is less than zero
     */
    public final void setPrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("price must not be less than zero");
        }
        this.price = price;
    }

    /**
     * Returns the hash code for this item.
     * 
     * @return the hash code for this item
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.desc == null) ? 0 : this.desc.hashCode());
        result = prime * result + this.price;
        return result;
    }

    /**
     * Compares two items for equality. The result is true if and only if the
     * argument is not null and is an Item object that has the same description
     * and price as this item.
     * 
     * @param obj
     *            the object to compare this item against
     * @return true if the given object represents an Item equivalent to this
     *         item, false otherwise
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Item other = (Item) obj;
        if (this.desc == null) {
            if (other.desc != null) {
                return false;
            }
        } else if (!this.desc.equals(other.desc)) {
            return false;
        }
        if (this.price != other.price) {
            return false;
        }
        return true;
    }

    /**
     * Returns a string representation of this item. The returned string is the
     * item's description followed by a space, then a dollar sign, then the
     * item's price.
     * 
     * @return a string representation of this item
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.desc + " $" + this.price;
    }

    /**
     * Compares two items numerically by their price. If the items have the same
     * price then the the items are compared lexicographically using their
     * descriptions.
     * 
     * <p>
     * The value 0 is returned if both items have the same price.
     * 
     * <p>
     * A negative value is returned if this item has a price less than the other
     * item, or if both items have the same price and this item has a
     * description that is lexicographically less than the other item
     * description.
     * 
     * <p>
     * A positive value is returned if this item has a price greater than the
     * other item, or if both items have the same price and this item has a
     * description that is lexicographically greater than the other item
     * description.
     * 
     * @param other
     *            the item to be compared
     * @return see description above
     */
    @Override
    public int compareTo(Item other) {
        int diff = this.getPrice() - other.getPrice();
        if (diff == 0) {
            return this.getDescription().compareTo(other.getDescription());
        }
        return diff;
    }

}
