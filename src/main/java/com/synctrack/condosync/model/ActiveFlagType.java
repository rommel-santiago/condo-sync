package com.synctrack.condosync.model;

public enum ActiveFlagType {

  Yes("Y"),
  No("N");

  private String value;

  ActiveFlagType(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

}
