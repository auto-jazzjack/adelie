import {Schema} from "./model";

type Position = {
    idx: number
}

export const Parser = (body: string): Schema => {

    let start = {idx: 0} as Position
    return queryGen(body, start)
}

export function findContext(content: string, last: number): string[] {
    let retv = [] as string[]
    let start = {idx: 0} as Position
    findContext0(content, start, last, retv)
    return retv
}

export function findContext0(content: string, start: Position, last: number, stack: string[]) {

    if (content.charAt(start.idx++) !== '{') {
    }

    let before = "";
    while ((start.idx <= last) && (content.length > start.idx)) {
        let word1 = getWord(content, start, last);

        //This means that we need to move into +1 depth
        if (word1 === "{") {
            start.idx--;
            stack.push(before)
            findContext0(content, start, last, stack)
        } else if (word1 === "}") {
            stack.pop()
            break;
        } else {
            before = word1;
        }

    }
}

function queryGen(schema: string, idx: Position): Schema {
    let retv = {} as Schema;
    retv.nextField = new Map<String, Schema>()
    retv.currentField = new Set<String>()


    if (schema.charAt(idx.idx++) !== '{') {
        //throw new Ex("Query should start with '{' character");
    }

    let before = "";
    while (schema.length > idx.idx) {
        let word1 = getWord(schema, idx, schema.length);

        //This means that we need to move into +1 depth
        if (word1 === "{") {
            idx.idx--;

            if (before.length === 0) {
                //throw new RuntimeException("Invalid Query exception near " + idx.get());
            }
            //Without getting two world, we cannot determine whether it is leaf node or not.
            //So in case of +1 depth case, let's remove before world
            retv.currentField.delete(before);
            retv.nextField.set(before, queryGen(schema, idx));
        } else if (word1 === "}") {
            break;
        } else if (word1 === undefined) {
            break;
        } else {
            //leaf node
            retv.currentField.add(word1);
            before = word1;
        }

    }
    return retv;

}

//This me method get string and index.
//Return the first world exist between idx to next whitespace.
function getWord(content: string, start: Position, last: number): string {
    let retv = ""
    skipBlank(content, start, last);
    while ((start.idx <= last) && (content.length > start.idx)) {
        let c = content.charAt(start.idx++);
        switch (c) {
            case '\n':
            case '\t':
            case ' ':
                return retv.toString();
            case '{':
            case '}':
                if (retv.length > 0) {
                    start.idx--;
                    return retv;
                } else {
                    return c;
                }
            default:
                retv += c
        }

    }
    return retv;
}

//helper to skip blank
function skipBlank(content: string, start: Position, last: number) {
    while ((start.idx <= last) && (content.length > start.idx)) {
        switch (content.charAt(start.idx++)) {
            case '\n':
            case '\t':
            case ' ':
                break;
            default:
                start.idx--;
                return;
        }
    }
}