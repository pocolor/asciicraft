#!/bin/bash

ITEMS_DIR="./src/main/resources/items"

ITEMS_ARRAY=$(find "$ITEMS_DIR" -name "*.json" -type f | xargs -n1 basename | sed 's/\.json$//' | jq -R . | jq -s .)

JSON_FILE="./json_schemas/block_json_schema.json"

jq --argjson items "$ITEMS_ARRAY" '.properties.itemDropped.enum = $items' "$JSON_FILE" > "${JSON_FILE}.tmp"

if [ $? -eq 0 ]; then
    mv "${JSON_FILE}.tmp" "$JSON_FILE"
    echo "Successfully updated JSON file with item list."
else
    rm "${JSON_FILE}.tmp"
    echo "Error updating JSON file." >&2
    exit 1
fi