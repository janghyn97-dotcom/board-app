#!/bin/bash
echo '```mermaid'
echo 'erDiagram'
echo ''
grep -E 'CREATE TABLE|^\s+[a-z_]+ ' schema.sql
echo '```'
