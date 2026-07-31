---
description: "Minimize JavaScript script code while preserving behavior and API contracts"
name: "Minimize Script"
argument-hint: "Target file/selection and constraints (e.g., keep Bootstrap, no backend changes)"
agent: "agent"
model: "GPT-5 (copilot)"
---
Minimize and simplify JavaScript in the target code without changing user-visible behavior.

Default mode:
- Conservative cleanup (readability-first reduction)
- Edit files directly in the workspace
- If no explicit target is provided, operate on script blocks in the active file

Inputs:
- Primary target: ${input:Target file or selected script block}
- Constraints: ${input:Constraints and must-keep items}

Requirements:
1. Preserve existing functionality and endpoint contracts.
2. Reduce duplication and unnecessary branching.
3. Keep code readable and maintainable.
4. Avoid introducing new dependencies unless explicitly requested.
5. Keep error handling robust; do not remove important guards.

Process:
1. Identify repetitive patterns and collapse them into small reusable helpers.
2. Normalize API response handling in one place when payload shapes vary.
3. Replace verbose DOM logic with concise, clear utilities where safe.
4. Keep naming explicit enough for maintenance.

Output format:
1. Summary of what was simplified and why.
2. Exact file edits.
3. Risks/regressions checked.
4. Optional next micro-optimizations (only if behavior-safe).

Apply edits directly to workspace files.
