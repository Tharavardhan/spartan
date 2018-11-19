package com.spartan.spartanbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MyOrder {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private int orderid;
 @Column(nullable = false)
 private int cartid;
 public int getOrderid() {
  return orderid;
 }
 public void setOrderid(int orderid) {
  this.orderid = orderid;
 }
 public int getCartid() {
  return cartid;
 }
 public void setCartid(int cartid) {
  this.cartid = cartid;
 }
 public int getPid() {
  return pid;
 }
 public void setPid(int pid) {
  this.pid = pid;
 }
 public String getProduct_Name() {
  return product_Name;
 }
 public void setProduct_Name(String product_Name) {
  this.product_Name = product_Name;
 }
 public int getQuantity() {
  return quantity;
 }
 public void setQuantity(int quantity) {
  this.quantity = quantity;
 }
 public int getPrice() {
  return price;
 }
 public void setPrice(int price) {
  this.price = price;
 }
 @Column(nullable = false)
 private int pid;
 @Column(nullable = false)
 private String product_Name;
 @Column(nullable = false)
 private int quantity;
 @Column(nullable = false)
 private int price;
}
