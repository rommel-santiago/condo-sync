package com.synctrack.condosync.model;

public enum WorkItemType {
  WORKER,
  MATERIAL,
  TOOL,
  UNKNOWN;

  public static WorkItemType fromString(String value) {
    if (value == null) {
      return UNKNOWN;
    }

    try {
      return WorkItemType.valueOf(value.toUpperCase());
    } catch (IllegalArgumentException ex) {
      return UNKNOWN;
    }
  }
}
